import java.util.*;

class RandomizedSet {
    private final List<Integer> nums;
    private final Map<Integer, Integer> idxMap;
    private final Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        // 이미 존재하면 삽입 실패
        if (idxMap.containsKey(val)) {
            return false;
        }

        // 맨 뒤에 추가 + 인덱스 기록
        idxMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        // 없으면 삭제 실패
        if (!idxMap.containsKey(val)) {
            return false;
        }

        int removeIdx = idxMap.get(val);
        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);

        // 지울 자리에 마지막 값을 덮어쓴다 (자기 자신 삭제인 경우에도 안전)
        nums.set(removeIdx, lastVal);
        idxMap.put(lastVal, removeIdx);

        // 마지막 원소 제거 + map에서 val 제거
        nums.remove(lastIdx);
        idxMap.remove(val);

        return true;
    }

    public int getRandom() {
        int randIdx = random.nextInt(nums.size()); // 0 ~ size-1
        return nums.get(randIdx);
    }
}