package caelrin.GlassGesturesInMotion;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by agibson on 1/11/14.
 */
public class GesturesInMotionService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("BOUND", "Hello World");
        return null;
    }
}
