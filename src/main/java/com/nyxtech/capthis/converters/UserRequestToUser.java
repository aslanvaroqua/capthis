package com.nyxtech.capthis.converters;

import com.nyxtech.capthis.entity.User;
import com.nyxtech.capthis.models.UserRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by varoqua on 12/10/15.
 */
@Component
public class UserRequestToUser implements Converter<UserRequest, User> {

    @Override
    public User convert(UserRequest userRequest) {

        checkNotNull(userRequest, "user request cannot be null");
        checkArgument(!isNullOrEmpty(userRequest.getFirstName()), "firstName cannot be null or empty");
        checkArgument(!isNullOrEmpty(userRequest.getLastName()), "lastName cannot be null or empty");
        checkArgument(!isNullOrEmpty(userRequest.getEmail()), "email cannot be null or empty");
        checkArgument(!isNullOrEmpty(userRequest.getCity()), "city cannot be null or empty");
        checkArgument(!isNullOrEmpty(userRequest.getState()), "state cannot be null or empty");
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setState(userRequest.getState());
        user.setCity(userRequest.getCity());
        user.setEmail(userRequest.getEmail());
        return user;
    }
}
