package truyen;

public class Sort75 {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
*
* 🏫 Tưởng tượng

Bạn có một hàng học sinh đứng lộn xộn:

học sinh áo đỏ (0)

học sinh áo trắng (1)

học sinh áo xanh (2)

Nhiệm vụ của bạn: xếp họ lại thành [đỏ | trắng | xanh].
Mà bạn chỉ được đi từ đầu đến cuối hàng 1 lần duy nhất, vừa đi vừa đổi chỗ.

✂️ Chia 3 vùng

Bạn tưởng tượng cái hàng được chia làm 3 phần:

Bên trái: chỉ toàn học sinh áo đỏ (0)

Ở giữa: toàn học sinh áo trắng (1)

Bên phải: toàn học sinh áo xanh (2)

Ban đầu, ba vùng chưa rõ ràng → ta dùng 3 cây cột mốc để đánh dấu:

low = chỗ tiếp theo để đặt áo đỏ

mid = vị trí đang kiểm tra

high = chỗ tiếp theo để đặt áo xanh

📏 Quy tắc khi gặp từng học sinh

Nếu gặp áo đỏ (0): đưa ngay sang bên trái (swap mid với low), sau đó cả low và mid đều bước lên.

Nếu gặp áo trắng (1): đúng chỗ rồi → chỉ cho mid đi tiếp.

Nếu gặp áo xanh (2): đưa ngay sang bên phải (swap mid với high), kéo high lại gần hơn, nhưng mid đứng im để kiểm tra bạn mới vừa đổi lên.

🧩 Ví dụ cụ thể

Mảng: [2, 0, 2, 1, 1, 0]

Bắt đầu: low=0, mid=0, high=5

nums[mid]=2 → đưa sang phải → [0, 0, 2, 1, 1, 2], high=4

nums[mid]=0 → đưa sang trái → [0, 0, 2, 1, 1, 2], low=1, mid=1

nums[mid]=0 → lại đưa sang trái → [0, 0, 2, 1, 1, 2], low=2, mid=2

nums[mid]=2 → đưa sang phải → [0, 0, 1, 1, 2, 2], high=3

nums[mid]=1 → đúng chỗ rồi → mid=3

nums[mid]=1 → đúng chỗ rồi → mid=4

Kết thúc vì mid > high.
Kết quả: [0, 0, 1, 1, 2, 2]
*
* */


/*
*
* public class SortColorsCounting {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        // Bước 1: đếm
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // Bước 2: ghi đè lại mảng
        int index = 0;
        for (int i = 0; i < count0; i++) nums[index++] = 0;
        for (int i = 0; i < count1; i++) nums[index++] = 1;
        for (int i = 0; i < count2; i++) nums[index++] = 2;
    }

    // test nhanh
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColorsCounting().sortColors(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        // Output: 0 0 1 1 2 2
    }
}

* */