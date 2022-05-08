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
		challengeRatings: [],
		dice: []
	},
	mounted () {
		axios
			.get('dice')
			.then(response => {
				this.dice = response.data;
				console.log(this.dice);
			});
		
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
			axios
				.post('monsters', monsterInput)
				.then(response => console.log(response.data));
		},
		addAction: function() {
			this.monsterInput.actions.push({
				attacks: []
			});
		},
		addAttack: function(action) {
			action.attacks.push({
				numberPerRound: null,
				relevantAbility: null,
				baseDamage: {
					die: {
						name: null,
						averageRoll: null
					},
					numberOfDice: null
				}
			});
		}
	}
});