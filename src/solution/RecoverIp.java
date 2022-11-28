package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LZN
 * @Title RecoverIp
 * @ProjectName my-test
 * @Description 给定一个字符串，恢复ip
 * @date 2022-11-27 22:22
 **/
public class RecoverIp {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    static int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dsf(s, 0, 0);
        return ans;
    }

    public void dsf(String s, int segId, int segStart) {
        //如果找到了4段IP地址，并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        //如果还没有到第4段ip地址，就已经遍历完成了所有的字符串，那么就提前回溯
        if (segStart == s.length()) {
            return;
        }
        //由于不能到前导0，如果当前数字为0，那么这一段ip地址只能为0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dsf(s, segId + 1, segStart + 1);
        }
        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dsf(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
