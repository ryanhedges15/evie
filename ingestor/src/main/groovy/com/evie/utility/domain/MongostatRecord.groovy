package com.evie.utility.domain

import org.springframework.data.annotation.Id

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient

/**
 * Created by rmhedge on 12/6/15.
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement
class MongostatRecord {

    @XmlTransient
    @Id
    private String id;

    private String host
    private int num;
    private int numberConnections;
    private int numberDeletes;
    private int numberFlushes;
    private int  numberGetmore;
    private int numberInserts;
    private String bytesOfNetworkTrafficIn
    private String bytesOfNetworkTrafficOut;
    private String numberQueries;

    //private int num;



    //{"new-host-2":{"ar|aw":"0|0","command":"1|0","conn":"1","delete":"*0","flushes":"0","getmore":"0","host":"new-host-2","insert":"*0","netIn":"79b","netOut":"18k","qr|qw":"0|0","query":"*0","res":"69.0M","time":"20:32:35","update":"*0","vsize":"377.0M"}}

}
