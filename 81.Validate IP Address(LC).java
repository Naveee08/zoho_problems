class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() == 0) return "Neither";
        
        // Check if it's potentially IPv4 or IPv6
        if (IP.indexOf(".") >= 0) return IPV4(IP);
        if (IP.indexOf(":") >= 0) return IPV6(IP);
        
        return "Neither";
    }

    private String IPV4(String ip) {
        // Check if IP starts or ends with a dot
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') return "Neither";
        
        // Split by dots
        String[] components = ip.split("\\.");
        
        // Check if there are exactly 4 components
        if (components.length != 4) return "Neither";
        
        for (String comp : components) {
            // Check if component length is valid
            if (comp.length() == 0 || comp.length() > 3 || (comp.charAt(0) == '0' && comp.length() > 1)) return "Neither";
            
            // Check if all characters are digits
            for (char ch : comp.toCharArray()) {
                if (ch < '0' || ch > '9') return "Neither";
            }
            
            // Check if the number is within range (0–255)
            int num = Integer.parseInt(comp);
            if (num < 0 || num > 255) return "Neither";
        }
        
        return "IPv4";
    }

    private String IPV6(String ip) {
        // Check if IP starts or ends with a colon
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') return "Neither";
        
        // Split by colons
        String[] components = ip.split(":");
        
        // Check if there are exactly 8 components
        if (components.length != 8) return "Neither";
        
        for (String comp : components) {
            // Check if component length is valid
            if (comp.length() == 0 || comp.length() > 4) return "Neither";
            
            // Check if all characters are valid hexadecimal digits
            for (char ch : comp.toLowerCase().toCharArray()) {
                if ((ch < '0' || ch > '9') && (ch < 'a' || ch > 'f')) return "Neither";
            }
        }
        
        return "IPv6";
    }
}
