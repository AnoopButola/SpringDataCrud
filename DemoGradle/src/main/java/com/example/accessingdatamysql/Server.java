package com.example.accessingdatamysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.IdentifierGenerator;







@Entity
public class Server {

	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO, generator = "server_gen")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "server_gen")
	 
	//@Id
    //@TableGenerator(name = "server_gen", table = "CC_SEQUENCE", pkColumnName = "SEQUENCE_NAME", pkColumnValue = "CC_SERVER_SEQ", valueColumnName = "NEXT_VALUE", allocationSize = 1,initialValue=-1)
   //@Parameter(name = CustomSequenceGenrator.INCREMENT_PARAM, value = "1") ,
	@GenericGenerator(name ="server_gen", strategy = "com.example.accessingdatamysql.CustomSequenceGenrator",
	parameters = {
			//@Parameter(name = CustomSequenceGenrator.INCREMENT_PARAM, value = "1"),
			//@Parameter(name = CustomSequenceGenrator.INITIAL_PARAM, value = "1"),
			
			//@Parameter(name = CustomSequenceGenrator.OPT_PARAM, value = "pooled"),
			     @Parameter(name = IdentifierGenerator.GENERATOR_NAME, value = "CC_SEQUENCE"),
			     @Parameter(name = CustomSequenceGenrator.SEGMENT_COLUMN_PARAM, value = "SEQUENCE_NAME"),
			     @Parameter(name = CustomSequenceGenrator.VALUE_COLUMN_PARAM, value = "NEXT_VALUE"),
			     @Parameter(name = CustomSequenceGenrator.SEGMENT_VALUE_PARAM, value = "CC_SERVER_SEQ"),
	
	})
	
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "server_gen")
     @Column(name = "id")
   private Long  id;
	
	private  String serverType;
	private String hostName;
	private String serverIp;
	private String serverPort;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}*/
	public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	
	
	
	
	
	
	
	
}
