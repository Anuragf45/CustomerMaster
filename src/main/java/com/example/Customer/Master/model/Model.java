package com.example.Customer.Master.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document(collection = "CustomerMaster100")
@Data
public class Model {

    List<DropdownValue> dropdownValues = new ArrayList<>();
    @Id
    private String apiField;
    private String targetSystemId;
    private String masterType;
    private String program;
    private boolean isPopupRequired;
    private int tabNumber;


    @Data
   public static class DropdownValue {
        private String name;
        private String value;

    }
}
//  @Data
//   class DropdownValue {
//    private String name;
//    private String value;
//
//}
