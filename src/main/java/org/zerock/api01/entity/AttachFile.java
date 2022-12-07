package org.zerock.api01.entity;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class AttachFile {

    @Id
    private String uuid;

    private String fileName;



}
