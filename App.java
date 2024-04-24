import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ngày, tháng, năm từ người dùng
        System.out.print("Nhập ngày: ");
        int day = scanner.nextInt();
        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();
        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        // Tính toán ngày tiếp theo
        int[] nextDate = getNextDate(day, month, year);

        // Hiển thị ngày tiếp theo
        System.out.println("Ngày tiếp theo là: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]);

        scanner.close();
    }

    public static int[] getNextDate(int d, int m, int y) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Kiểm tra năm nhuận
        if (y % 400 == 0 || (y % 100 != 0 && y % 4 == 0)) {
            daysInMonth[2] = 29;
        }

        // Kiểm tra ngày hợp lệ
        if (m < 1 || m > 12 || d < 1 || d > daysInMonth[m]) {
            return new int[]{-1, -1, -1}; // Trả về một mảng giá trị không hợp lệ nếu ngày không hợp lệ
        }

        // Nếu là ngày cuối cùng của tháng
        if (d == daysInMonth[m]) {
            d = 1;
            m++;
            if (m > 12) {
                m = 1;
                y++;
            }
        } else {
            d++;
        }

        return new int[]{d, m, y};
    }
}