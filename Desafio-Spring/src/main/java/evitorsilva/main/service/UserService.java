package evitorsilva.main.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import evitorsilva.main.model.TokenObject;
import evitorsilva.main.model.User;
import evitorsilva.main.model.UserRepository;

@Service
public class UserService implements UserImpl {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void createUser(User user) {
        String pass = user.getPassword();
        // criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        System.out.println(user);
        repository.save(user);
    }

    @Override
    public TokenObject LoginUser(@Validated User FazerLogin) {

        var user = repository.findByUsername(FazerLogin.getUsername());

        var senha = encoder.matches(FazerLogin.getPassword(), user.getPassword());

        if (!senha || user == null) {
            return null;
        }

        Algorithm algorithm = Algorithm.HMAC256("baeldung");

        TokenObject tokenObject = new TokenObject();
        String tk = JWT.create().withClaim("User", user.getUsername()).withClaim("Permission", user.getRoles())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 50000L)).sign(algorithm);

        tokenObject.setToken(tk);
        return tokenObject;

    }

}
