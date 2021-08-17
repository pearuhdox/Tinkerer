package item;

public class CustomShieldData {

	int model;
	int blockModel;
	
	BlockingType blockType;
	int maxBlock;
	
	Persistence persistence;
	
	int playerBlockEffectID;
	int entityBlockEffectID;
	
	int maxTime;
	int cooldown;
	
	int maxDurability;
	int bashID;
	
	BlockAngle blockAngle;
	
	boolean canBlockArrows;
	
	boolean disableResistant;
	
	int disableTime;

	public CustomShieldData() {
		model = 0;
		blockModel = 0;
		blockType = null;
		maxBlock = 0;
		persistence = null;
		playerBlockEffectID = 0;
		entityBlockEffectID = 0;
		maxTime = 0;
		cooldown = 0;
		maxDurability = 0;
		bashID = 0;
		blockAngle = null;
		canBlockArrows = false;
		disableResistant = false;
		disableTime = 0;
	}	

	public CustomShieldData(int model, int blockModel, BlockingType blockType, int maxBlock, Persistence persistence,
			int playerBlockEffectID, int entityBlockEffectID, int maxTime, int cooldown, int maxDurability, int bashID,
			BlockAngle blockAngle, boolean canBlockArrows, boolean disableResistant, int disableTime) {
		super();
		this.model = model;
		this.blockModel = blockModel;
		this.blockType = blockType;
		this.maxBlock = maxBlock;
		this.persistence = persistence;
		this.playerBlockEffectID = playerBlockEffectID;
		this.entityBlockEffectID = entityBlockEffectID;
		this.maxTime = maxTime;
		this.cooldown = cooldown;
		this.maxDurability = maxDurability;
		this.bashID = bashID;
		this.blockAngle = blockAngle;
		this.canBlockArrows = canBlockArrows;
		this.disableResistant = disableResistant;
		this.disableTime = disableTime;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getBlockModel() {
		return blockModel;
	}

	public void setBlockModel(int blockModel) {
		this.blockModel = blockModel;
	}

	public BlockingType getBlockType() {
		return blockType;
	}

	public void setBlockType(BlockingType blockType) {
		this.blockType = blockType;
	}

	public int getMaxBlock() {
		return maxBlock;
	}

	public void setMaxBlock(int maxBlock) {
		this.maxBlock = maxBlock;
	}

	public Persistence getPersistence() {
		return persistence;
	}

	public void setPersistence(Persistence persistence) {
		this.persistence = persistence;
	}

	public int getPlayerBlockEffectID() {
		return playerBlockEffectID;
	}

	public void setPlayerBlockEffectID(int playerBlockEffectID) {
		this.playerBlockEffectID = playerBlockEffectID;
	}

	public int getEntityBlockEffectID() {
		return entityBlockEffectID;
	}

	public void setEntityBlockEffectID(int entityBlockEffectID) {
		this.entityBlockEffectID = entityBlockEffectID;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	public void setMaxDurability(int maxDurability) {
		this.maxDurability = maxDurability;
	}

	public int getBashID() {
		return bashID;
	}

	public void setBashID(int bashID) {
		this.bashID = bashID;
	}

	public BlockAngle getBlockAngle() {
		return blockAngle;
	}

	public void setBlockAngle(BlockAngle blockAngle) {
		this.blockAngle = blockAngle;
	}

	public boolean isCanBlockArrows() {
		return canBlockArrows;
	}

	public void setCanBlockArrows(boolean canBlockArrows) {
		this.canBlockArrows = canBlockArrows;
	}

	public boolean isDisableResistant() {
		return disableResistant;
	}

	public void setDisableResistant(boolean disableResistant) {
		this.disableResistant = disableResistant;
	}

	public int getDisableTime() {
		return disableTime;
	}

	public void setDisableTime(int disableTime) {
		this.disableTime = disableTime;
	}
	
}