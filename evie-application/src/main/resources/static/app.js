var { Router,
      Route,
      IndexRoute,
      IndexLink,
      Link } = ReactRouter;


var CardVisual =  React.createClass({
    render:function() {
       var cardVisualStyle = {
            padding:0,
            margin:0,
            width: 230,
            height:250,
            borderStyle: "inset",
            verticalAlign:"center",
            display: "table",
            marginRight:"auto",
            marginLeft:"auto",
            marginTop: 10,
            paddingTop:10,
            backgroundColor: this.props.bgColor,
            verticalAlign: "center"
        };

        var pStyle = {
            color:"#FFFFFF",
            fontSize: 64,
            fontFamily: "sans-serif",
            textAlign: "center"
        }
        return (
        <div style={cardVisualStyle}>
           <p style={pStyle}> {this.props.letter} </p>
        </div>
        );
    }
});

var DatabaseDetailsBox =  React.createClass({
    render:function() {
       var databaseDetailsStyle = {
            padding:0,
            margin:0,
            width: 250,
            height:25,
            backgroundColor: "#FFFFFF",
            display: "inline-block",
            fontFamily: "sans-serif",
            fontSize: 12,
            textAlign: "center"
        };
        return (
        <div style={databaseDetailsStyle}>
           <p>Database Size:{this.props.sizeInMB}</p>
           <p>Number of Collections:{this.props.numberCollections}</p>
           <p>Sharded:{this.props.isSharded}</p>
        </div>
        );
    }
});

var DatabaseCard = React.createClass({

    render:function() {
        var databaseCardStyle = {
            height:400,
            width:260,
            padding:0,
            margin:0,
            backgroundColor:"#FFF",
            alignItems : "flex-start",
            verticalAlign : "center",
            WebKitFilter: "drop-shadow(0px 0px 5px #666)",
            filter: "drop-shadow(0px 0px 5px #666)"
        };
        return (
        <div style={databaseCardStyle}>
            <CardVisual {...this.props}/>
            <DatabaseDetailsBox {...this.props}/>
        </div>
        );
    }
});



var HorizontalDatabaseCardPane2 = React.createClass({

    render:function() {
        var horizontalBoxStyle = {
            height:"100%",
            width:"800",
            padding:0,
            backgroundColor:"#FFFFFF",
            display:"flex",
            alignItems:"initial",
            paddingLeft:20,
            verticalAlign: "top"


        };
        return (
        <div style={horizontalBoxStyle}>
            <DatabaseCard letter="1" sizeInMB="100" numberCollections="5" isSharded="false" bgColor="#8190a8"/>
            <DatabaseCard letter="2" sizeInMB="200" numberCollections="5" isSharded="false" bgColor="#bcbc85"/>
            <DatabaseCard letter="3" sizeInMB="100" numberCollections="5" isSharded="false" bgColor="#3ca527"/>
            <DatabaseCard letter="4" sizeInMB="200" numberCollections="5" isSharded="false" bgColor="#d87334"/>
        </div>
        );
    }
});

var HorizontalDatabaseCardPane = React.createClass({

  loadDatabasesFromServer: function() {

    var self = this;
    $.ajax({
        url: "http://localhost:8100/databases/all",
      }).then(function(data) {
        self.setState({ databases: data});
      });

  },
  getInitialState: function() {
    return { databases: [] };
  },
  componentDidMount: function() {
    this.loadDatabasesFromServer();
  },
  render:function() {
          var horizontalBoxStyle = {
              height:"100%",
              width:"800",
              padding:0,
              backgroundColor:"#FFFFFF",
              display:"flex",
              alignItems:"initial",
              paddingLeft:20,
              verticalAlign: "top"
          };
    var renderData = [];
    for(var i=0;i<this.state.databases.length;i++){
        var card = <DatabaseCard letter={this.state.databases[i].databaseName} sizeInMB="100" numberCollections="5" isSharded="false" bgColor={"#"+((1<<24)*Math.random()|0).toString(16)}/>
        renderData.push(card);
    }
    return (<div style={horizontalBoxStyle}>{renderData}</div> );
  }
});

var ResourcesPage = React.createClass({
    render:function() {
        return(
            <div>
                 <ul>
                     <li><a href="http://localhost:8100/swagger-ui.html">REST Docs</a></li>
                     <li><a href="https://github.com/ryanhedges15/evie">GitHub Project</a></li>
                 </ul>
            </div>
        )
    }
})

var App = React.createClass({
  render:function() {
    return(
    <div>
       <h1>EVIE MongoDB Manager</h1>
       <ul className="header">
          <li><a>Home</a></li>
          <li><a>Databases</a></li>
          <li><a>Cluster Health</a></li>
          <li><a>Development Resources</a></li>
        </ul>
        <HorizontalDatabaseCardPane />
    </div>
    );
  }
});





 ReactDOM.render(
    <div>
        <Router>
            <Route path="/" component={App}/>
            <Route path="/devtools" component={ResourcesPage}/>
        </Router>
    </div>,
     document.querySelector("#container")
 );



