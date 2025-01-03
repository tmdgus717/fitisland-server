package happyperson.fitisland.domain.oauthjwt.dto;

import happyperson.fitisland.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    private final User user;

    @Override
    public Map<String, Object> getAttributes() {

        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add((GrantedAuthority) user::getRole);

        return collection;
    }

    @Override
    public String getName() {

        return user.getName();
    }

    public String getUsername() {

        return user.getUsername();
    }

    public Long getId() {
        return user.getId();
    }
}
