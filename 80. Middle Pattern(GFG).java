class GfG
{
	void printPattern(String s)
	{
	    StringBuilder sb = new StringBuilder();
	    int len=s.length()/2;
	    
	    for(int i=len;i<s.length();i++){
	        sb.append(s.charAt(i));
	        System.out.print(" "+sb.toString()+"$");
	    }
	    
	     for(int i=0;i<len;i++){
	        sb.append(s.charAt(i));
	        System.out.print(" "+sb.toString()+"$");
	    }
    }
}
