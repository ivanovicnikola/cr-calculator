var app = new Vue({
	el: '#monster',
	data: {
		monsterInput: {
		    armorClass: null,
		    strength: {
		        abilityScore: null
		    },
		    dexterity: {
		        abilityScore: null
		    },
		    constitution: {
		        abilityScore: null
		    },
		    intelligence: {
		        abilityScore: null
		    },
		    wisdom: {
		        abilityScore: null
		    },
		    charisma: {
		        abilityScore: null
		    },
		    numberOfHitDice: null,
		    size: null,
		    challengeRating: {
		        ordinal: null,
		        value:null,
		        experiencePoints: null
		    },
		    actions: []
		},
		challengeRatings: []
	},
	mounted () {
		axios
			.get('dice')
			.then(response => console.log(response.data));
		
		axios
			.get('challengeRatings')
			.then(response => {
				this.challengeRatings = response.data;
				console.log(this.challengeRatings);
			});
	},
	methods: {
		submitMonster: function(monsterInput) {
			event.preventDefault();
			console.log(monsterInput);
		}
	}
});