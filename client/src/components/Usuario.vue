<template>
	<div class="container">
		<div class="row usuario">
			<div class="col-5">
				<img
					:src="'uploads/user/' + user.id"
					class="rounded img-thumbnail profileUser"
					alt="profile-image"
					onerror="this.src='static/pet.png'"
				/>
			</div>
			<div class="col-7">
				<div class="text-center">
					<h5 class="font-weight-bold">
						Este é {{ user.firstName }} {{ user.lastName }}!
					</h5>
					<p>
						<strong> Email: </strong>
						{{ user.email }}
					</p>
					<p>
						<strong> Telefone: </strong>
						{{ user.telefone }}
					</p>
					<p>
						<strong> Endereço: </strong>
						{{ user.logradouro }}, nr. {{ user.numero }},
						{{ user.bairro }}, {{ user.complemento }},
						{{ user.cidade }}-{{ user.estado }},
						{{ user.cep }}
					</p>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: "Usuario",
	props: {
		user: Object,
	},
};
</script>

<style>
.profileUser {
	width: 200px;
	height: 200px;
	object-fit: cover;
	object-position: top;
}
</style>