function FindProxyForURL(url, host) {
    if (shExpMatch(host, "security-kyoiku.*") || 
        shExpMatch(host, "localhost.*") || 
        shExpMatch(host, "111\.108\.206\.210.*")) {
        return "PROXY 127.0.0.1:8000";
    } else {
        return "DIRECT";
    }
}