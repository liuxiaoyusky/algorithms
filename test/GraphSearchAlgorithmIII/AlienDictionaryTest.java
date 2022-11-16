package GraphSearchAlgorithmIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionaryTest {

    @Test
    void alienOrder() {
        AlienDictionary a = new AlienDictionary();
        assertEquals(a.alienOrder(new String []{"ddyd","dtmndwnzn","fzixtmxfimfdd",
                "xnimfmdxdymxwm","txydyyyjdtyjxntxixid","jfdynwyfwftzxzxftfft",
                "jninjxxfijxy","wjtnfyyxyyyzifxiy","wjzyjdxjdttywfdxfjmxwz",
                "wnmnfii","yfxfyixjwnnxdy","ywymzjydywifdnjwznin","ywnwyjnjiyxxyjtt",
                "ynmy","zjfmyniyxdwt","nmzzwtymjwzyxntxdmfx"}), "dimfxtjwyzn");
    }
}