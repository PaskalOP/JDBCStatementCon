package org.example.jdbcWork.DtoForQuery;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Data
public class WorkerTableDto {
    private long id;
    private String name;
    private LocalDate birthday;
    private String level;
    private int selary;
    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private List<String> userCol;


    public WorkerTableDto(List<Object> dataFromSelect, List<String> userCol) {
        this.userCol = userCol;
        for (int i = 0; i < dataFromSelect.size(); i++) {
            if(userCol.get(i).equals("id")&& dataFromSelect.get(i) instanceof Long) this.id=(long)dataFromSelect.get(i);
            if(userCol.get(i).equals("name")&& dataFromSelect.get(i) instanceof String) this.name=(String)dataFromSelect.get(i);
            if(userCol.get(i).equals("birthday")&& dataFromSelect.get(i) instanceof java.sql.Date){
                java.sql.Date data = (java.sql.Date)dataFromSelect.get(i);
                this.birthday= data.toLocalDate();
            }
            if(userCol.get(i).equals("level")&& dataFromSelect.get(i) instanceof String) this.level=(String) dataFromSelect.get(i);
            if(userCol.get(i).equals("selary")&& dataFromSelect.get(i) instanceof Integer) this.selary=(int) dataFromSelect.get(i);

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<userCol.size();i++) {
            if(userCol.get(i).equals("id")) sb.append(id + " ");
            if(userCol.get(i).equals("name")) sb.append(name + " ");
            if(userCol.get(i).equals("birthday")) sb.append(birthday.format(formater) + " ");
            if(userCol.get(i).equals("level")) sb.append(level + " ");
            if(userCol.get(i).equals("selary")) sb.append(selary+ " ");
        }
        return sb.toString();

    }
//тест класса
//    public static void main(String[] args) {
//        List<Object> dataFromSelect = new ArrayList<>();
//        dataFromSelect.add(1);
//        dataFromSelect.add("Valya");
//        dataFromSelect.add("1987/02/16");
//
//        List<String> userCol = new ArrayList<>();
//        userCol.add("id");
//        userCol.add("name");
//        userCol.add("birthday");
//
//        WorkerTableDto worker= new WorkerTableDto(dataFromSelect,userCol);
//        System.out.println(worker.toString());
//    }
}
