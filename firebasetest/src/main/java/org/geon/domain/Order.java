package org.geon.domain;


import java.util.Date;

import com.google.auto.value.AutoValue.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private String store;
	private String menu;
	private Integer idx;
	private Date time;


}
