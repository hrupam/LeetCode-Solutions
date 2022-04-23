public class Codec {
    
    private Map<Integer,String> map=new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash=longUrl.hashCode();
        map.put(hash,longUrl);
        return String.valueOf(hash);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hash=Integer.parseInt(shortUrl);
        return map.get(hash);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));