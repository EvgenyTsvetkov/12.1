import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@Data

public class BillboardManager {
    private int limit = 10;
    private Billboard[] billboards = new Billboard[0];

    public BillboardManager(int limit) {this.limit = limit;}

    public void addBillboard(Billboard movie) {
        int length = billboards.length + 1;
        Billboard[] tmp = Arrays.copyOf(billboards, length);
        tmp[length - 1] = movie;
        billboards = tmp;
    }

    public Billboard[] OutputOfAllMovies() {
        Billboard[] result = new Billboard[billboards.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = billboards[i];
        }
        return result;
    }

    public Billboard[] OutputMaximumLimitOfTheLastAddedMovies() {
        int resultLength = (this.limit > billboards.length) ? billboards.length : this.limit;
        Billboard[] result = new Billboard[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = billboards.length - i - 1;
            result[i] = billboards[index];
        }
        return result;
    }
}
