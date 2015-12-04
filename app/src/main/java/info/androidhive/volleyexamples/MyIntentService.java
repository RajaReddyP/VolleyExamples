package info.androidhive.volleyexamples;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;

import info.androidhive.volleyexamples.utils.Const;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "info.androidhive.volleyexamples.action.FOO";
    private static final String ACTION_BAZ = "info.androidhive.volleyexamples.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "info.androidhive.volleyexamples.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "info.androidhive.volleyexamples.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Const.showLog("onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Const.showLog("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Const.showLog("onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Const.showLog("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Const.showLog("onBind");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Const.showLog("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Const.showLog("onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Const.showLog("onTaskRemoved");
        super.onTaskRemoved(rootIntent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String msg = intent.getStringExtra("foo");
        Const.showLog("IS onHandleIntent "+msg);

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Const.showLog("Service running");
            } catch (Exception e) {
            }


                Const.showLog("Service running "+msg);

        }
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
