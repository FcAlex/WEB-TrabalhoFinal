<template>
	<div>
		<Header></Header>
		<section class="container p-1">
			<article id="somos" class="card text-center my-3">
				<div class="card-header">
					<h1><i class="fa fa-paw"></i> Quem Somos</h1>
				</div>
				<div class="card-body text-justify">
					<p>Lorem Ipsum is simply dummy text of the printing and
					typesetting industry. Lorem Ipsum has been the industry's
					standard dummy text ever since the 1500s, when an unknown
					printer took a galley of type and scrambled it to make a
					type specimen book. It has survived not only five centuries,
					but also the leap into electronic typesetting, remaining
					essentially unchanged.</p>
					<p>It was popularised in the 1960s with
					the release of Letraset sheets containing Lorem Ipsum
					passages, and more recently with desktop publishing software
					like Aldus PageMaker including versions of Lorem Ipsum.</p>
				</div>
			</article>

			<article id="fale" class="card text-center my-3">
				<div class="card-header">
					<h1><i class="fa fa-paw"></i> Fale Conosco</h1>
				</div>
				<div class="row m-3">
					<div class="col-md-8">
						<form>
							<div class="row">
								<div class="col-6">
									<div class="form-group">
										<label for="name"> Nome</label>
										<input
											type="text"
											class="form-control"
											id="name"
											placeholder="Informe seu nome"
											required="required"
											v-model="nome"
										/>
									</div>

									<div class="form-group">
										<label for="email"> Email </label>
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i
														:class="animacao"
														aria-hidden="true"
													></i>
												</div>
											</div>
											<input
												type="email"
												class="form-control"
												id="email"
												placeholder="Qual o seu email"
												required="required"
												@focus="animacaoEmailFocus()"
												@blur="animacaoEmailBlur()"
												v-model="email"
											/>
										</div>
									</div>

									<div class="form-group">
										<label for="subject"> Assunto</label>
										<select
											id="subject"
											name="subject"
											class="form-control"
											required="required"
											v-model="assunto"
										>
											<option value="na" selected="">
												O que você deseja:
											</option>
											<option value="ajuda">Ajuda</option>
											<option value="sugestao">
												Sugestão
											</option>
											<option value="apoio">Apoio</option>
										</select>
									</div>
								</div>

								<div class="col-6">
									<div class="form-group">
										<label for="name"> Mensagem </label>
										<textarea
											name="message"
											id="message"
											class="form-control"
											rows="9"
											cols="25"
											required="required"
											placeholder="Nos envie sua mensagem, dúvida ou sugestão..."
											v-model="mensagem"
										></textarea>
									</div>
								</div>

								<div class="col-12">
									<button
										type="button"
										@click="salvarMensagem('arquivo.json')"
										class="btn btn-primary pull-right"
										id="btnContactUs"
									>
										<i
											class="fa fa-paper-plane"
											aria-hidden="true"
										></i>
										Enviar Mensagem
									</button>
								</div>
							</div>
						</form>
					</div>

					<div class="card col-4">
						<img
							class="card-img-top"
							src="../assets/cat_sobre.jpg"
							alt="Card image cap"
						/>
						<div class="card-body">
							<h5 class="card-title">
								<i
									class="fa fa-comments"
									aria-hidden="true"
								></i>
								Envie-nos sua mensagem!
							</h5>
							<p class="card-text">
								Seu feedback é muito importante para nós! A
								partir dele, saberemos o que podemos melhorar e
								continuar. Seja parte dessa rede do bem!
							</p>
						</div>
					</div>
				</div>
			</article>
		</section>

		<Footer></Footer>
	</div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
	name: "Sobre",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			animacao: "fa fa-address-card",
			nome: "",
			email: "",
			assunto: "",
			mensagem: "",
		};
	},
	methods: {
		animacaoEmailFocus() {
			this.animacao = "fa fa-address-card-o";
		},
		animacaoEmailBlur() {
			this.animacao = "fa fa-address-card";
		},
		salvarMensagem(name) {
			let dados = {
				nome: this.nome,
				email: this.email,
				assunto: this.assunto,
				mensagem: this.mensagem,
			};
			let texto = "Nome: " + this.nome + "\nEmail: " + this.email + "\nAssunto: " + this.assunto + "\nMensagem: " + this.mensagem; 
			var link = document.createElement("a");
			link.href =
				"data:application/octet-stream;charset=utf-8," +
				texto;
			link.download = "arquivo.txt";
			link.click();
		},
	},
};
</script>

<style>
</style>