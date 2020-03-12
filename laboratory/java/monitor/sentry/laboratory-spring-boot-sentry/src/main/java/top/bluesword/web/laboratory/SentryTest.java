package top.bluesword.web.laboratory;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.SentryClientFactory;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

/**
 * @author 李林峰
 */
public class SentryTest {
    private static SentryClient sentry;

    public static void main(String... args) {
        Sentry.init();
        sentry = SentryClientFactory.sentryClient();
        SentryTest sentryTest = new SentryTest();
        sentryTest.logWithStaticApi();
        sentryTest.logWithInstanceApi();
    }

    private void unsafeMethod() {
        throw new UnsupportedOperationException("llf : UnsupportedOperationException");
    }

    private void logWithStaticApi() {
        Sentry.getContext().recordBreadcrumb(
                new BreadcrumbBuilder().setMessage("llf : BreadcrumbBuilder setMessage").build()
        );
        Sentry.getContext().setUser(
                new UserBuilder().setEmail("hello@sentry.io").build()
        );
        Sentry.getContext().addExtra("extra", "thing");
        Sentry.getContext().addTag("tagName", "tagValue");
        Sentry.capture("llf : Sentry.capture 2019年11月14日 08:23:36");
        try {
            unsafeMethod();
        } catch (Exception e) {
            Sentry.capture(e);
        }
    }

    /**
     * Examples that use the SentryClient instance directly.
     */
    private void logWithInstanceApi() {
        Context context = sentry.getContext();
        context.recordBreadcrumb(new BreadcrumbBuilder().setMessage("User made an action").build());
        context.setUser(new UserBuilder().setEmail("hello@sentry.io").build());
        sentry.sendMessage("llf : sentry.sendMessage 2019年11月14日 08:23:28");
        try {
            unsafeMethod();
        } catch (Exception e) {
            sentry.sendException(e);
        }
    }
}