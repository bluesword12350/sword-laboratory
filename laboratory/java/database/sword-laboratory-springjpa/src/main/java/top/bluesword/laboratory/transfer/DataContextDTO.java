package top.bluesword.laboratory.transfer;

import lombok.Data;

import java.util.List;

/**
 * @author 李林峰
 */
@Data
public class DataContextDTO {

    private String briefIntroduction;

    private List<DataFragmentDTO> fragments;

}
