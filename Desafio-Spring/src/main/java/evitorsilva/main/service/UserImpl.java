package evitorsilva.main.service;

import evitorsilva.main.model.TokenObject;
import evitorsilva.main.model.User;

public interface UserImpl {
        void createUser(User user);

        TokenObject LoginUser(User FazerLogin);
}
