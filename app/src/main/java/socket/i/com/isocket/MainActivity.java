package socket.i.com.isocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_sock)
    Button btnSock;
    private MyWebSocketListener mSocketListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSocketListener = new MyWebSocketListener();

    }

    @OnClick(R.id.btn_sock)
    public void onViewClicked() {
        Request request = new Request.Builder()
                .url("ws://echo.websocket.org")
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newWebSocket(request, mSocketListener);
        client.dispatcher().executorService().shutdown();
    }
}
