FCKXml.prototype={LoadUrl:function(c){this.Error=false;var a;var f=FCKTools.CreateXmlObject("XmlHttp");f.open("GET",c,false);f.send(null);if(f.status==200||f.status==304||(f.status==0&&f.readyState==4)){a=f.responseXML;if(!a){a=(new DOMParser()).parseFromString(f.responseText,"text/xml");}}else{a=null;}if(a){try{var d=a.firstChild;}catch(b){a=(new DOMParser()).parseFromString(f.responseText,"text/xml");}}if(!a||!a.firstChild){this.Error=true;if(window.confirm('Error loading "'+c+'" (HTTP Status: '+f.status+").\r\nDo you want to see the server response dump?")){alert(f.responseText);}}this.DOMDocument=a;},SelectNodes:function(b,a){if(this.Error){return new Array();}var d=new Array();var c=this.DOMDocument.evaluate(b,a?a:this.DOMDocument,this.DOMDocument.createNSResolver(this.DOMDocument.documentElement),XPathResult.ORDERED_NODE_ITERATOR_TYPE,null);if(c){var e=c.iterateNext();while(e){d[d.length]=e;e=c.iterateNext();}}return d;},SelectSingleNode:function(b,a){if(this.Error){return null;}var c=this.DOMDocument.evaluate(b,a?a:this.DOMDocument,this.DOMDocument.createNSResolver(this.DOMDocument.documentElement),9,null);if(c&&c.singleNodeValue){return c.singleNodeValue;}else{return null;}}};