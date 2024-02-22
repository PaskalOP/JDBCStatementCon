package org.example.jdbcWork.DtoForQuery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProjectTableDto {
    private long id;
    private  long CLIENT_ID;
    private LocalDate start_date;
    private LocalDate finish_Date;
    private long MONTH_COUNT;

    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private List<String> userCol;


    public ProjectTableDto(List<Object> dataFromSelect, List<String> userCol) {
        this.userCol = userCol;
        for (int i = 0; i < dataFromSelect.size(); i++) {
            if(userCol.get(i).equals("id")&& dataFromSelect.get(i) instanceof Long) this.id=(long)dataFromSelect.get(i);
            if(userCol.get(i).equals("CLIENT_ID")&& dataFromSelect.get(i) instanceof Long) this.CLIENT_ID =(long)dataFromSelect.get(i);
            if(userCol.get(i).equals("start_date")&& dataFromSelect.get(i) instanceof java.sql.Date){
                java.sql.Date data = (java.sql.Date)dataFromSelect.get(i);
                this.start_date = data.toLocalDate();
            }
            if(userCol.get(i).equals("finish_Date")&& dataFromSelect.get(i) instanceof java.sql.Date){
                java.sql.Date data = (java.sql.Date)dataFromSelect.get(i);
                this.finish_Date = data.toLocalDate();
            }
            if(userCol.get(i).equals("MONTH_COUNT")&& dataFromSelect.get(i) instanceof Long) this.MONTH_COUNT =(long)dataFromSelect.get(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<userCol.size();i++) {
            if(userCol.get(i).equals("id")) sb.append(id + " ");
            if(userCol.get(i).equals("CLIENT_ID")) sb.append(CLIENT_ID + " ");
            if(userCol.get(i).equals("start_date")) sb.append(start_date.format(formater) + " ");
            if(userCol.get(i).equals("finish_Date")) sb.append(finish_Date.format(formater) + " ");
            if(userCol.get(i).equals("MONTH_COUNT")) sb.append(MONTH_COUNT + " ");

        }
        return sb.toString();

    }
}
