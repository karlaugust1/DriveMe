package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.PedidoBusiness;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.Pedido;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class PedidoController {
	
	@Autowired
	PedidoBusiness business;
	
	@GetMapping(value = {"/pedidos", "/pedidos/{id}"})
	public ServiceResponse getPedidos(@PathVariable (name = "id", required = false) Long id) {
		return business.listById(id);
	}
	
	@PostMapping(value = {"pedidos/adicionar/{idUsuario}"})
	public ServiceResponse addPeca(@RequestBody Peca peca, @PathVariable (name = "idUsuario", required = true) Long idUsuario) {
		return business.adicionarPeca(peca, idUsuario);
	}
	
	@PostMapping(value = {"pedidos/remover/{idPecaPedido}"})
	public ServiceResponse removePeca(@RequestBody Pedido pedido, @PathVariable (name = "idPecaPedido", required = true) Long idPecaPedido) {
		return business.removerPeca(pedido, idPecaPedido);
	}
	
	@PostMapping(value = {"pedidos/finalizar"})
	public ServiceResponse finishPedido(@RequestBody Pedido pedido) {
		return business.finalizarPedido(pedido);
	}
	
	@GetMapping(value = {"/pedidos/usuarios/{idUsuario}"})
	public ServiceResponse getPedidosPorUsuario(@PathVariable (name = "idUsuario", required = true) Long id) {
		return business.findByUsuarioId(id);
	}
	
	@GetMapping(value = {"/pedidos/finalizados/usuarios/{idUsuario}"})
	public ServiceResponse getPedidosFinalizadosPorUsuario(@PathVariable (name = "idUsuario", required = true) Long id) {
		return business.findFinalizadosByUsuarioId(id);
	}
}
