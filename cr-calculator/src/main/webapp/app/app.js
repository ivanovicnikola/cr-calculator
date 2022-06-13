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
		dice: [],
		monsterResult: {
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
		    hitDie: {
		    	name: null,
		    	averageRoll: null
		    },
		    size: null,
		    challengeRating: {
		        ordinal: null,
		        value:null,
		        experiencePoints: null
		    },
		    actions: []
		},
	    displayResult: false
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
				.then(response => {
					this.monsterResult = response.data;
					this.displayResult = true;
					console.log(this.monsterResult);
				});
		},
		addAction: function() {
			this.monsterInput.actions.push({
				attacks: []
			});
			this.monsterResult.actions.push({
				attacks: []
			});
		},
		addAttack: function(actionIndex) {
			this.monsterInput.actions[actionIndex].attacks.push({
				type: null,
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
			this.monsterResult.actions[actionIndex].attacks.push({
				type: null,
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
		},
		removeAction: function(index) {
			this.monsterInput.actions.splice(index, 1);
			this.monsterResult.actions.splice(index, 1);
		},
		removeAttack: function(actionIndex, attackIndex) {
			this.monsterInput.actions[actionIndex].attacks.splice(attackIndex, 1);
			this.monsterResult.actions[actionIndex].attacks.splice(attackIndex, 1);
		},
		bonusString: function(bonus) {
			return (bonus>0)?"+" + bonus: bonus;
		}
	}
});