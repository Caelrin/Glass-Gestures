package caelrin.GlassGesturesInMotion;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.TimelineManager;

/**
 * Created by agibson on 1/11/14.
 */
public class GesturesInMotionService extends Service {

    private static final String TAG = "GesturesTag";
    private static final String LIVE_CARD_TAG = "gestures";

    private TimelineManager mTimelineManager;
    private LiveCard mLiveCard;

    @Override
    public void onCreate() {
        super.onCreate();
        mTimelineManager = TimelineManager.from(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mLiveCard == null) {
            Log.e(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>> Starting UP!");
            mLiveCard = mTimelineManager.createLiveCard(LIVE_CARD_TAG);

            mLiveCard.publish(LiveCard.PublishMode.REVEAL);
            Log.d(TAG, "Done publishing LiveCard");
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mLiveCard != null && mLiveCard.isPublished()) {
            mLiveCard.unpublish();
            mLiveCard = null;
        }
        super.onDestroy();
    }
}
