package org.example.jdbcWork.DtoForQuery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AgeTypeDto {
    private String type;
    private String name;
    private LocalDate birthday;
    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private List<String> userCol;

    public AgeTypeDto(List<Object> dataFromSelect, List<String> userCol) {
        this.userCol = userCol;
        for (int i = 0; i < dataFromSelect.size(); i++) {
            if (userCol.get(i).equals("type") && dataFromSelect.get(i) instanceof String)
                this.type = (String) dataFromSelect.get(i);
            if (userCol.get(i).equals("name") && dataFromSelect.get(i) instanceof String)
                this.name = (String) dataFromSelect.get(i);
            if (userCol.get(i).equals("birthday") && dataFromSelect.get(i) instanceof java.sql.Date) {
                java.sql.Date data = (java.sql.Date) dataFromSelect.get(i);
                this.birthday = data.toLocalDate();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < userCol.size(); i++) {
            if (userCol.get(i).equals("type")) sb.append(type + " ");
            if (userCol.get(i).equals("name")) sb.append(name + " ");
            if (userCol.get(i).equals("birthday")) sb.append(birthday.format(formater) + " ");
        }
        return sb.toString();
    }
}