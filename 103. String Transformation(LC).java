class Solution {
    public int numberOfWays(String s, String t, long k) {
        int n=s.length();
        String ss=s+s;
        int first=ss.indexOf(t);

        if(first==-1){
            return 0;
        }
        int zeroTargets=first==0?1:0;
        int paired=ss.indexOf(s,1);
        int frequency=n/paired;
        int nonZeroTargets=frequency-zeroTargets;

        final int MOD= 1_000_000_007;

        long nInverse=modPow(n, MOD-2, MOD);

        long ways0=(modPow(n-1, k, MOD)+(n-1)*((k%2==0)?1:-1))%MOD;
        ways0=(ways0*nInverse)%MOD;
        long ways1=(modPow(n-1, k, MOD)-((k%2==0)?1:-1))%MOD;
        ways1=(ways1*nInverse)%MOD;

        if(ways0<0) ways0+=MOD;
        if(ways1<0) ways1+=MOD;

        return (int)((zeroTargets*ways0+nonZeroTargets*ways1)%MOD);
    }

    private long modPow(long base, long exp, long mod){
        long result=1;
        base=base%mod;
        while(exp>0){
            if(exp%2==1){
                result=(result*base)%mod;
            }
            base=(base*base)%mod;
            exp/=2;
        }
        return result;
    }
}
