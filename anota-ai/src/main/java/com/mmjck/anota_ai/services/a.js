import { S3Client, GetObjectCommand, PutObjectCommand } from "@aws-sdk/clients3"

const client = new S3Client({ region: "us-east-2" })

export const handler = async (event) => {
    try {

        for (const record of event.Records) {
            console.log("iniciando processamento de mensagem", record)
            const body = JSON.parse(body.Message)
            const ownerId = body.ownerId
            try {
                var bucketName = "anotaai-catalog-marketplace-v123"
                var filename = `${ownerId}-catalog.json`

                const catalog = await getS3Object(bucketName, filename)
                const catalogData = JSON.parse(catalog)

                if (body.type == "products") {
                    updateOrAddItem(catalogData.product, body, "id")
                } else {
                    updateOrAddItem(catalogData.categories, body, "id")
                }

                await putS3Object(bucketName, filename, JSON.stringfy(catalogData))
            } catch (err) {
                console.log("err: " + err)
                throw new Error("Error ao processar mensagem do SQS")
            }

            return {
                status: "success"
            }
        }
    } catch (error) {
        console.log("error:", error)
        throw new Error("Error ao processar mensagem do SQS")
    }
};


async function getS3Object(bucket, key) {
    const getCommand = new GetObjectCommand({
        Bucket: bucket,
        Key: key
    })

    try {
        const response = await client.send(getCommand)

        return streamToString(response.Body)
    } catch (e) {
        throw new Error("Error getting object from bucket")
    }

}

async function streamToString(stream) {
    return new Promise((resolve, reject) => {
        const chunks = []

        stream.on("data", (chunk) => chunks.push(chunk))
        stream.on("end", () => resolve(Buffer.concat(chunks).toString("utf-8")));
        stream.on("error", reject)
    })
}

async function putS3Object(dstBucket, dstKey, content) {
    try {
        const putCommand = new PutObjectCommand({
            Bucket: dstBucket,
            Key: dstKey,
            Body: content,
            ContentType: "application/json"

        })
    } catch (err) {
        console.log("err: " + err);
        return;
    }
}

async function updateOrAddItem(catalog, item, key) {
    const index = catalog.findIndex(e => e.id == item)

    if (index != -1) {
        catalog[index] = { ...catalog[item], ...item }
    } else {
        catalog.push(item)
    }

}