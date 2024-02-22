package org.example.jdbcWork.DtoForQuery;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClientTableDto {
    private long ID;
    private  String name;
    private long project_count;
    private List<String> userCol;


    public ClientTableDto(List<Object> dataFromSelect, List<String> userCol) {
        this.userCol = userCol;
        for (int i = 0; i < dataFromSelect.size(); i++) {
            if(userCol.get(i).equals("ID")&& dataFromSelect.get(i) instanceof Long) this.ID=(long)dataFromSelect.get(i);
            if(userCol.get(i).equals("name")&& dataFromSelect.get(i) instanceof String) this.name =(String) dataFromSelect.get(i);
            if(userCol.get(i).equals("project_count")&& dataFromSelect.get(i) instanceof Long) this.project_count =(long)dataFromSelect.get(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<userCol.size();i++) {
            if(userCol.get(i).equals("ID")) sb.append(ID + " ");
            if(userCol.get(i).equals("name")) sb.append(name + " ");
            if(userCol.get(i).equals("project_count")) sb.append(project_count + " ");

        }
        return sb.toString();

    }
}
