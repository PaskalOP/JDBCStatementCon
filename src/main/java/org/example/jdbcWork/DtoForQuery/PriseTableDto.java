package org.example.jdbcWork.DtoForQuery;

import java.math.BigDecimal;
import java.util.List;

public class PriseTableDto {
    private long project_id;
    private BigDecimal price;
    private List<String> userCol;

    public PriseTableDto (List<Object> dataFromSelect, List<String> userCol) {
        this.userCol = userCol;
        for (int i = 0; i < dataFromSelect.size(); i++) {
            if(userCol.get(i).equals("project_id")&& dataFromSelect.get(i) instanceof Long) this.project_id=(long)dataFromSelect.get(i);
            if(userCol.get(i).equals("price")&& dataFromSelect.get(i) instanceof BigDecimal) this.price =(BigDecimal) dataFromSelect.get(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < userCol.size(); i++) {
            if (userCol.get(i).equals("project_id")) sb.append(project_id + " ");
            if (userCol.get(i).equals("price")) sb.append(price + " ");
        }
        return sb.toString();
    }
}
