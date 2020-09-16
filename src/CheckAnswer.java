public class CheckAnswer {
    public String[] check(String a, String b){
        String [] diff = new String [a.length()];
        if(a.length()!=b.length()){
            diff[0]="not same length";
            return diff;
        }else{
            diff[0]="start";
        }
        int slow = 1;
        int cur = 0;
        while(cur<a.length()){
            if(a.charAt(cur)!=b.charAt(cur)){
                diff[slow++]=""+cur+a.charAt(cur)+b.charAt(cur);
            }
            cur++;
        }
        return diff;
    }

    public static String printthisthing(String [] check){
        StringBuilder sb = new StringBuilder();
        for(String str: check){
            sb.append(str);
        }
        return new String(sb);
    }

    public static void main(String [] args){
        CheckAnswer checkAnswer = new CheckAnswer();
        System.out.println(
                printthisthing(checkAnswer.check("l6h26d6k10e12r4b3d25k40s5e26f26g14l12y27u30p1l7o5j17t19",
                        "l6h26d6k10e12r4b3d25k40s5e26f26g14l12y27u30k1l7o5j17t19"))
        );
    }
}
