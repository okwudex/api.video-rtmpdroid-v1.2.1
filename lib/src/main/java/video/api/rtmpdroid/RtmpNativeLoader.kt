package video.api.rtmpdroid

/**
 * Statically loads native library.
 * For internal usage only.
 */
object RtmpNativeLoader {
    init {
        // PACKED build: OpenSSL (libcrypto/libssl) is statically linked
        // *into* librtmpdroid.so, and no standalone libcrypto.so/libssl.so
        // are shipped in the AAR. Loading them separately makes Android
        // fall back to the namespace-blocked system /system/lib64/libcrypto.so
        // → UnsatisfiedLinkError crash on first ApiVideoLiveStreamView mount.
        // Match upstream apivideo/api.video-rtmpdroid v1.2.1 exactly: load
        // only rtmpdroid (which carries OpenSSL statically).
        System.loadLibrary("rtmpdroid")
    }
}