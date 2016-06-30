package online.klok.mobpos;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klok on 30/6/16.
 */
public class RegisterRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL = "http://mobpos.comuf.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String password, String username, String email, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("password", password);
        params.put("username", username);
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
