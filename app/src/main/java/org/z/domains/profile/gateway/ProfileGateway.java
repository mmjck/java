package org.z.domains.profile.gateway;

import java.util.List;
import org.z.domains.profile.entities.Profile;

public interface ProfileGateway {
    public void create(final Profile entity);
    public void update(final Profile entity);
    
    public Profile findById(final String id);
    public Profile findByLogin(final String login);


    public List<Profile> searchByLogin(final String login);

    public List<Profile> findFollowedByProfileId(final String login);
}
