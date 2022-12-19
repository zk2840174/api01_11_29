package org.zerock.api01.entity;


import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Embeddable
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhotoAttachFile {

    @Id
    private String uuid;

    private String fileName;

    private int fileIdx;
}
