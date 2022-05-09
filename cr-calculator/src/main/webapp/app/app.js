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
		},
		removeAction: function(index) {
			this.monsterInput.actions.splice(index, 1);
		},
		removeAttack: function(action, index) {
			action.attacks.splice(index, 1);
		},
		bonusString: function(bonus) {
			return (bonus>0)?"+" + bonus: bonus;
		},
		attackString: function(actionIndex, attackIndex) {
			let attack = this.monsterResult.actions[actionIndex].attacks[attackIndex];
			return attack.numberPerRound + ((attack.numberPerRound == 1)?" attack":" attacks") + ": " + this.bonusString(attack.attackBonus) + " to hit. Hit: " + (attack.baseDamage.averageValue + attack.damageBonus) + " (" + attack.baseDamage.numberOfDice + attack.baseDamage.die.name + this.bonusString(attack.damageBonus) + ") damage.";
		}
	}
});