package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>Transfer object for Stuff entity class.</p>
 * <p>Has the fields from Stuff class.</p>
 */
@Data
@AllArgsConstructor
public class StuffTO implements Serializable {

    private Long id;

    private String name;

    private String value;

    private Long userId;

}
