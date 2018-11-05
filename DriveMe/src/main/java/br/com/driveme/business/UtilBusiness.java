package br.com.driveme.business;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UtilBusiness {
	
	@Autowired
	PecaBusiness pecaBo;
	
	@Autowired
	UsuarioBusiness usuarioBo;
	
	@Autowired
	PedidoBusiness pedidoBo;
	
	public ServiceResponse getInformacoesIniciais() {
		Map<String, Object> result = new HashMap<>();
		
		try {
			result.put("produtos", pecaBo.list().size());
			result.put("usuarios", usuarioBo.listAll().size());
			result.put("funcionamento", new Random().nextInt(180));
			result.put("compras", pedidoBo.list().size());
			return new ServiceResponse(ResponseType.SUCCESS, "Sucesso obtendo informações iniciais","Sucesso obtendo informações iniciais", result);
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponse(ResponseType.ERROR, "Erro ao obter informações iniciais","Erro ao obter informações iniciais", result);
		}
	}

}
