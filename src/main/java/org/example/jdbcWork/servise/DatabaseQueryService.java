package org.example.jdbcWork.servise;

import org.example.jdbcWork.Database;
import org.example.jdbcWork.DtoForQuery.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DatabaseQueryService {
    private Database db;
    private List<Object> temp;
    public DatabaseQueryService(){

        this.db = Database.getInstance();
        temp=new ArrayList<>();
    }
    public List<WorkerTableDto> findMinSelary(List<String> userColunms, String absolutPathFile){
        List<WorkerTableDto> selectResult = new ArrayList<>();
        String query = PropertyReader.queryReader(absolutPathFile);
        List<Object> queryObjects = db.executeResult( query,userColunms);

        for(int i=0; i<queryObjects.size();){
            while (temp.size()!=userColunms.size()){
                temp.add(queryObjects.get(i));
                i++;
            }
            WorkerTableDto row = new WorkerTableDto(temp,userColunms);
            selectResult.add(row);
            temp.clear();
        }
        return selectResult;
    }

    public <T>List<T> getSelectData(List<String> userColunms, String absolutPathFile, Function<List<Object>, T> mapper){
        List<T> selectResult = new ArrayList<>();
        String query = PropertyReader.queryReader(absolutPathFile);
        List<Object> queryObjects = db.executeResult( query,userColunms);

        for(int i=0; i<queryObjects.size();){
            while (temp.size()!=userColunms.size()){
                temp.add(queryObjects.get(i));
                i++;
            }
            T row = mapper.apply(temp);
            selectResult.add(row);
            temp.clear();
        }
        return selectResult;
    }

    public static void main(String[] args) {
        DatabaseQueryService qs = new DatabaseQueryService();
        List<String> userColForMinSelary  = new ArrayList();
        userColForMinSelary .add("id");
        userColForMinSelary .add("name");
        userColForMinSelary .add("selary");
        userColForMinSelary .add("birthday");

        List<String> userColumnForMaxMounth = new ArrayList<>();
        userColumnForMaxMounth.add("id");
        userColumnForMaxMounth.add("start_date");
        userColumnForMaxMounth.add("MONTH_COUNT");


        List<String> userColumnForMaxProjects = new ArrayList<>();
        userColumnForMaxProjects.add("ID");
        userColumnForMaxProjects.add("name");
        userColumnForMaxProjects.add("project_count");


        List<String> userColumnForPriseOfProjacts = new ArrayList<>();
        userColumnForPriseOfProjacts.add("project_id");
        userColumnForPriseOfProjacts.add("price");

        List<String> userColForAgeType  = new ArrayList();
        userColForAgeType.add("type");
        userColForAgeType.add("name");
        userColForAgeType.add("birthday");


        String minSelaryUrl = "/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/minSelary.sql";
        String maxMounthUrl = "/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/maxMonthCount.sql";
        String maxProjectsUrl = "/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/maxProjectCount.sql";
        String priseOfProjactsUrl = "/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/priseOfProject.sql";
        String ageTypeUrl = "/Users/mac/IdeaProjects/JDBCHomeWork/src/main/java/org/example/jdbcWork/sql/youngestOldest.sql";

        List<WorkerTableDto> selected =  qs.findMinSelary(userColForMinSelary  ,minSelaryUrl);
        System.out.println(selected);

        List<WorkerTableDto> select = qs.getSelectData(userColForMinSelary  ,minSelaryUrl, objects -> new WorkerTableDto(objects, userColForMinSelary ));
        System.out.println(select);

        List<ProjectTableDto> selectMaxMounth = qs.getSelectData(userColumnForMaxMounth, maxMounthUrl, objects -> new ProjectTableDto(objects, userColumnForMaxMounth));
        System.out.println(selectMaxMounth);

        List<ClientTableDto> selectMaxProject = qs.getSelectData(userColumnForMaxProjects, maxProjectsUrl, objects -> new ClientTableDto(objects, userColumnForMaxProjects));
        System.out.println(selectMaxProject );

        List<PriseTableDto> prisesOfProjects = qs.getSelectData(userColumnForPriseOfProjacts, priseOfProjactsUrl, objects -> new PriseTableDto(objects, userColumnForPriseOfProjacts));
        System.out.println(prisesOfProjects );

        List<AgeTypeDto> selectByAgeType = qs.getSelectData(userColForAgeType , ageTypeUrl, objects -> new AgeTypeDto(objects, userColForAgeType ));
        System.out.println(selectByAgeType );

    }
}
