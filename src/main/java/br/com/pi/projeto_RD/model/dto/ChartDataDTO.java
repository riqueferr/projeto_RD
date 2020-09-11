package br.com.pi.projeto_RD.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChartDataDTO {
    private List<Integer> data;
//    private String label;

    public void addData(Integer valor){
    if(data == null)
        data = new ArrayList<>();
    data.add(valor);
}
}
