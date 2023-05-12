package com.argentina.dolar.api.main.extractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.argentina.dolar.api.main.domain.Dollar;
import com.argentina.dolar.api.main.domain.DollarCreator;
import com.argentina.dolar.api.shared.AbstractResponseExtractor;

@Component
public class DollarExtractor extends AbstractResponseExtractor<Dollar> {

  private static final String NODE_NAME = "valores_principales";

  @Override
  public List<Dollar> extractData(
      final ClientHttpResponse response) throws IOException {
    List<Dollar> dolarList = new ArrayList<>();
    try {
      NodeList nodes = super.readRootNodeList(response.getBody());
      for(int i = 0; i < nodes.getLength() ; ++i) {
        String currNodeName = nodes.item(i).getLocalName();
        if(NODE_NAME.equals(currNodeName)) {
          Node node = nodes.item(i);
          NodeList list = node.getChildNodes();
          for(int x = 0; x < list.getLength() ; ++x) {
            if(list.item(x) != null) {
              NodeList listChild = list.item(x).getChildNodes();
              Map<String, String> fields = new HashMap<>();
              for(int a = 1; a < listChild.getLength() ; ++a) {
                String key = listChild.item(a).getLocalName();
                String value = listChild.item(a).getTextContent();
                fields.put(key, value);
              }
              if(!fields.isEmpty()) {
                dolarList.add(DollarCreator.createOfStrings(
                    fields.get("compra"), 
                    fields.get("venta"),
                    fields.get("agencia"), 
                    fields.get("nombre"), 
                    fields.get("variacion"), 
                    fields.get("ventaCero"), 
                    fields.get("decimales")));
              }
            }
          }
        }
      }
    } catch(Exception ex) {
      ex.printStackTrace();
    }
    return dolarList;
  }
   
}
