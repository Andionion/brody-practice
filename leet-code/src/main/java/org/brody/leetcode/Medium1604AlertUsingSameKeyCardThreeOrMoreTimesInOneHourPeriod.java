package org.brody.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/">1604. 警告一小时内使用相同员工卡大于等于三次的人</a>
 * <p>
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * <p>
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * <p>
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * <p>
 * 输出：["daniel"]
 * <p>
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * <p>
 * 输出：["bob"]
 * <p>
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * <p>
 * 示例 3：
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * <p>
 * 输出：[]
 * <p>
 * 示例 4：
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * <p>
 * 输出：["clare","leslie"]
 * <p>
 * 提示：
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * <p>
 * keyName.length == keyTime.length
 * <p>
 * keyTime 格式为 "HH:MM" 。
 * <p>
 * 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
 * <p>
 * 1 <= keyName[i].length <= 10
 * <p>
 * keyName[i] 只包含小写英文字母。
 *
 * @author Brody
 */
public class Medium1604AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod {

    public static void main(String[] args) {
        String[] keyName = {"a", "a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c", "c", "c", "c", "c", "c"};
        String[] keyTime = {"00:37", "11:24", "14:35", "21:25", "15:48", "20:28", "07:30", "09:26", "10:32", "20:10", "19:26", "08:13", "01:08", "15:49", "02:34", "06:48", "04:33", "07:18", "00:05", "06:44", "13:33", "04:12", "03:54"};

        Medium1604AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod solution = new Medium1604AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod();
        System.out.println(solution.alertNames(keyName, keyTime));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        // 将每个人对应的打卡时间转为分钟数，放入MAP中，然后对时间数目进行排序，当第三个时间减去第一个时间的时间间隔小于60时，意味着此人符合条件
        Map<String, List<Integer>> timeMap = new HashMap<>(10);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) {
            timeMap.putIfAbsent(keyName[i], new ArrayList<>());
            int hour = (keyTime[i].charAt(0) - '0') * 10 + (keyTime[i].charAt(1) - '0');
            int minute = (keyTime[i].charAt(3) - '0') * 10 + (keyTime[i].charAt(4) - '0');
            timeMap.get(keyName[i]).add(hour * 60 + minute);
        }
        timeMap.forEach((name, timeList) -> {
            Collections.sort(timeList);
            for (int i = 2; i < timeList.size(); i++) {
                if (timeList.get(i) - timeList.get(i - 2) <= 60) {
                    res.add(name);
                    break;
                }
            }
        });
        Collections.sort(res);
        return res;
    }
}
